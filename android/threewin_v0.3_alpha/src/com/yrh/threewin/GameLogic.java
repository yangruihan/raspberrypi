package com.yrh.threewin;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import android.util.Log;

public class GameLogic {

	// ��ͼ��1��ʾ���������飬0��ʾǽ��
	public final static int[][] MAP_7x7 = { { 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 1 }, };

	public final static int[][] MAP_8x8 = { { 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1 } };

	private GameView gameView;
	private int numberX; // x ���Ϸ�������� Ĭ��Ϊ7
	private int numberY; // y ���Ϸ�������� Ĭ��Ϊ7
	private int kindOfObj; // ��������������������С�ڵ���6, Ĭ��Ϊ6
	private Diamond[][] map; // ������ŷ���ĵ�ͼ
	private HashMap<Integer, Integer> removeList = new HashMap<Integer, Integer>(); // ������ż����������ķ���
	private int[][] tempMap; // ���������ʱ��ͼ�������жϵ�ͼ���Ƿ��п���ͨ�����������ķ���
	private int[][] inputMap; // ������¼����ʱ����ĵ�ͼ

	private static final int CHECK_INT = 6123;
	private static final int CHECK_DIA = CHECK_INT + 1;
	private int[] dirX = { -2, -1, 1, 2 }; // ��Ҫ�жϵ�X����仯
	private int[] dirY = { -2, -1, 1, 2 }; // ��Ҫ�жϵ�Y����仯
	private int[] tip = new int[4]; // ��¼��ʾ�����꼰����

	public GameLogic(int numberX, int numberY, int kindOfObj,
			int[][] input_map, GameView gameView) {
		this.numberX = numberX;
		this.numberY = numberY;
		this.kindOfObj = kindOfObj;
		this.gameView = gameView;
		this.inputMap = input_map;
		if (kindOfObj > 6) {
			this.kindOfObj = 6;
		}
		// ��ʼ��
		init(numberX, numberY, kindOfObj, input_map);

		/*-------*/
		debugPrint();
	}

	// ��ʼ������
	private void init(int numberX, int numberY, int kindOfObj, int[][] input_map) {
		map = new Diamond[numberX][numberY];
		for (int i = 0; i < numberX; i++) {
			for (int j = 0; j < numberY; j++) {
				if (input_map[i][j] == 1) {
					int id = 1 + (int) (Math.random() * kindOfObj);
					// �жϵ�ǰID�������Ƿ����
					while (!idIsOk(id, i, j)) {
						id = 1 + (int) (Math.random() * kindOfObj);
					}
					map[i][j] = new Diamond(Diamond.KIND_OBJ, id, i, j);
				} else {
					map[i][j] = new Diamond(Diamond.KIND_WALL, 0, i, j);
				}
			}
		}

		/*----------------------*/
		System.out.println("before check will remove");

		// ����Ƿ��л�����������Ļ��飬���û������������
		checkWillRemove(numberX, numberY, kindOfObj, inputMap);

	}

	private void checkWillRemove(int numberX, int numberY, int kindOfObj,
			int[][] input_map) {
		/*----------------------*/
		System.out.println("in check will remove");

		while (!haveWillRemoveDia()) {
			/*----------------------*/
			System.out.println("in have will remove dia loop");

			for (int i = 0; i < numberX; i++) {
				for (int j = 0; j < numberY; j++) {
					if (input_map[i][j] == 1) {
						int id = 1 + (int) (Math.random() * kindOfObj);
						// �жϵ�ǰID�������Ƿ����
						while (!idIsOk(id, i, j)) {
							id = 1 + (int) (Math.random() * kindOfObj);
						}
						map[i][j] = new Diamond(Diamond.KIND_OBJ, id, i, j);
					} else {
						map[i][j] = new Diamond(Diamond.KIND_WALL, 0, i, j);
					}
				}
			}
		}
	}

	// �жϵ�ǰλ�õ� ID �Ƿ����
	private boolean idIsOk(int id, int x, int y) {
		if (x - 2 >= 0) {
			if (map[x - 1][y].getId() == map[x - 2][y].getId()
					&& map[x - 1][y].getId() == id) {
				return false;
			}
		}
		if (y - 2 >= 0) {
			if (map[x][y - 2].getId() == map[x][y - 1].getId()
					&& map[x][y - 1].getId() == id) {
				return false;
			}
		}
		return true;
	}

	public final static int MOVE_SUCCESS = 1293; // �ƶ��ɹ�
	public final static int MOVE_ERROR = MOVE_SUCCESS + 1; // �����ƶ�
	public final static int MOVE_FAIL = MOVE_ERROR + 1; // �ƶ�ʧ��

	public int exchange(int x, int y, int moveX, int moveY) {
		if (x + moveX < 0 || x + moveX >= numberX || y + moveY < 0
				|| y + moveY >= numberY) {
			return MOVE_ERROR; // �����ƶ�ʧ��
		}

		// ����״̬
		int oldX = x;
		int oldY = y;

		x += moveX;
		y += moveY;

		// ����
		Diamond temp = map[oldX][oldY];
		map[oldX][oldY] = map[x][y];
		map[x][y] = temp;
		
		return MOVE_SUCCESS;
	}

	public int removeGoOn(int x, int y, int oldX, int oldY) {
		// �������
		if (!checkRemove()) {
			// �������ʧ�ܣ���ԭ״̬
			Diamond temp = map[oldX][oldY];
			map[oldX][oldY] = map[x][y];
			map[x][y] = temp;
			return MOVE_FAIL; // �����ƶ�ʧ��
		}

		// �������״̬��������Ƿ�������
		while (checkRemove()) {

		}

		return MOVE_SUCCESS; // �����ƶ��ɹ�
	}

	public boolean canRemove() {
		removeList.clear();
		for (int i = 0; i < numberX; i++) {
			for (int j = 0; j < numberY; j++) {
				// ÿһ����������Χ���
				checkAt(i, j, CHECK_DIA);
			}
		}
		// ���ִ����һ�飬û��һ��λ�ü���������б���û����Ҫ������λ��
		if (removeList.isEmpty()) {
			return false;
		}
		return true;
	}

	private boolean checkRemove() {

		if (!canRemove()) {
			return false;
		}

		/*-------*/
		System.out.println("before remove");
		debugPrint();
		// ����
		remove();

		/*-------*/
		System.out.println("after remove");
		debugPrint();

		// ����
		downMove();

		/*-------*/
		System.out.println("after down_move");
		debugPrint();

		// ����
		add();

		/*-------*/
		System.out.println("after add");
		debugPrint();

		// ����Ƿ���ͨ��������������ķ������û����������������
		checkWillRemove(numberX, numberY, kindOfObj, inputMap);

		/*-------*/
		System.out.println("after check will remove");
		debugPrint();

		return true;
	}

	private void add() {
		for (int i = 0; i < numberX; i++) {
			for (int j = 0; j < numberY; j++) {
				if (map[i][j] == null) {
					int id = 1 + (int) (Math.random() * kindOfObj);
					map[i][j] = new Diamond(Diamond.KIND_OBJ, id, i, j);
				}
			}
		}
	}

	private void downMove() {
		for (int i = 0; i < numberX; i++) {
			for (int j = numberY - 1; j >= 0; j--) {
				if (map[i][j] == null && j - 1 >= 0) {
					// �� null ���������ƶ�����
					upMoveNull(i, j);
				}
			}

		}
	}

	private void upMoveNull(int x, int y) {
		int loc = y;
		while (y - 1 >= 0) {
			// �� y �Ѿ���������ʱ�˳�
			if (y < 0) {
				return;
			}
			if (map[x][y - 1] == null) {
				loc = y;
				while (y - 1 >= 0 && map[x][y - 1] == null) {
					y--;
				}
				continue;
			} else if (map[x][y - 1].getKind() == Diamond.KIND_WALL) {
				loc = y;
				while (y - 1 >= 0
						&& map[x][y - 1].getKind() == Diamond.KIND_WALL) {
					y--;
				}
				continue;
			}
			Diamond temp = map[x][y - 1];
			map[x][y - 1] = null;
			map[x][loc] = temp;
			loc = y - 1;
			y--;
		}
	}

	private void remove() {
		Iterator<Entry<Integer, Integer>> iter = removeList.entrySet()
				.iterator();
		while (iter.hasNext()) {
			Entry<Integer, Integer> entry = iter.next();
			Integer key = entry.getKey();
			// �õ��������ķ��������
			int x = key % numberX;
			int y = key / numberX;
			// ֱ������
			map[x][y] = null;
		}
	}

	private boolean haveWillRemoveDia() {
		/*----------------------*/
		System.out.println("in have will remove dia");

		tempMap = new int[numberX][numberY];

		for (int i = 0; i < numberX; i++) {
			for (int j = 0; j < numberY; j++) {
				tempMap[i][j] = map[i][j].getId(); // tempMap ֻ��Ҫͨ��id���������жϼ���
			}
		}

		/*--------------*/
		System.out.println("tempMap init successful!");

		for (int i = 0; i < numberX; i++) {
			for (int j = 0; j < numberY; j++) {
				// �����ǰλ�ÿ������󽻻�������һ�£�������������������򷵻�True����֮False����ͬ
				if (i - 1 >= 0) {
					if (tryMoveCanRemove(i, j, -1, 0)) {
						return true;
					}
				}
				if (i + 1 < numberX) {
					if (tryMoveCanRemove(i, j, 1, 0)) {
						return true;
					}
				}
				if (j - 1 >= 0) {
					if (tryMoveCanRemove(i, j, 0, -1)) {
						return true;
					}
				}
				if (j + 1 < numberY) {
					if (tryMoveCanRemove(i, j, 0, 1)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	private boolean tryMoveCanRemove(int x, int y, int moveX, int moveY) {

		/*-----------------*/
		System.out.println("begin tryMoveCanRemove (" + x + ", " + y + ", "
				+ moveX + ", " + moveY + ")");

		int newX = x + moveX;
		int newY = y + moveY;

		int temp = tempMap[x][y];
		tempMap[x][y] = tempMap[newX][newY];
		tempMap[newX][newY] = temp;

		for (int i = 0; i < dirX.length; i++) {
			int tempX = newX + dirX[i];
			if (tempX >= 0 && tempX < numberX) {
				if (checkAt(tempX, newY, CHECK_INT)) {
					tip[0] = x;
					tip[1] = y;
					tip[2] = moveX;
					tip[3] = moveY;
					return true;
				}
			}
		}
		for (int i = 0; i < dirY.length; i++) {
			int tempY = newY + dirY[i];
			if (tempY >= 0 && tempY < numberY) {
				if (checkAt(newX, tempY, CHECK_INT)) {
					tip[0] = x;
					tip[1] = y;
					tip[2] = moveX;
					tip[3] = moveY;
					return true;
				}
			}
		}

		for (int i = 0; i < dirX.length; i++) {
			int tempX = x + dirX[i];
			if (tempX >= 0 && tempX < numberX) {
				if (checkAt(tempX, newY, CHECK_INT)) {
					tip[0] = x;
					tip[1] = y;
					tip[2] = moveX;
					tip[3] = moveY;
					return true;
				}
			}
		}
		for (int i = 0; i < dirY.length; i++) {
			int tempY = y + dirY[i];
			if (tempY >= 0 && tempY < numberY) {
				if (checkAt(x, tempY, CHECK_INT)) {
					tip[0] = x;
					tip[1] = y;
					tip[2] = moveX;
					tip[3] = moveY;
					return true;
				}
			}
		}

		// ���û���ҵ����������Ļ�Ҫ������
		temp = tempMap[x][y];
		tempMap[x][y] = tempMap[newX][newY];
		tempMap[newX][newY] = temp;
		return false;
	}

	private boolean checkAt(int x, int y, int kind) {

		if (kind == CHECK_INT) {
			if (x - 1 >= 0 && x + 1 < numberX) {
				if (tempMap[x - 1][y] == tempMap[x][y]
						&& tempMap[x][y] == tempMap[x + 1][y]) {
					return true;
				}
			}
			if (y - 1 >= 0 && y + 1 < numberY) {
				if (tempMap[x][y - 1] == tempMap[x][y]
						&& tempMap[x][y + 1] == tempMap[x][y]) {
					return true;
				}
			}
		}

		if (kind == CHECK_DIA) {
			if (x - 1 >= 0 && x + 1 < numberX) {
				if (map[x - 1][y].getId() == map[x][y].getId()
						&& map[x + 1][y].getId() == map[x][y].getId()) {
					int loc = x - 1 + y * numberX;
					removeList.put(loc, 1);
					removeList.put(loc + 1, 1);
					removeList.put(loc + 2, 1);
					map[x - 1][y].setPush(true);
					map[x][y].setPush(true);
					map[x + 1][y].setPush(true);
				}
			}
			if (y - 1 >= 0 && y + 1 < numberY) {
				if (map[x][y - 1].getId() == map[x][y].getId()
						&& map[x][y].getId() == map[x][y + 1].getId()) {
					removeList.put(x + y * numberX, 1);
					removeList.put(x + (y - 1) * numberY, 1);
					removeList.put(x + (y + 1) * numberX, 1);
					map[x][y + 1].setPush(true);
					map[x][y].setPush(true);
					map[x][y - 1].setPush(true);
				}
			}
			return true;
		}

		return false;
	}

	/* ���Թ��� */
	private void debugPrint() {
		for (int i = 0; i < numberY; i++) {
			for (int j = 0; j < numberX; j++) {
				if (map[j][i] != null) {
					System.out.print(map[j][i].getId() + " ");
				} else {
					System.out.print("n ");
				}
			}
			System.out.println();
		}
	}

	/* Get ���� */
	public Diamond getDiaAt(int x, int y) {
		if (x < numberX && x >= 0 && y < numberY && y >= 0) {
			return map[x][y];
		} else
			return null;
	}

	public int getNumberX() {
		return numberX;
	}

	public int getNumberY() {
		return numberY;
	}

	public int getKindOfObj() {
		return kindOfObj;
	}

	public Diamond[][] getMap() {
		return map;
	}

}
