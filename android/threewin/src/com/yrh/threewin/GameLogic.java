package com.yrh.threewin;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import android.util.Log;

public class GameLogic {

	public final static int[][] MAP_7x7 = { { 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 1 }, }; // ��ͼ��
																	// 1��ʾ���������飬0��ʾǽ�ڣ�7*7
	public final static int[][] MAP_8x8 = { { 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1 } };

	private GameView gameView;
	private int numberX; // x ���Ϸ�������� Ĭ��Ϊ8
	private int numberY; // y ���Ϸ�������� Ĭ��Ϊ8
	private int kindOfObj; // ��������������������С�ڵ���6, Ĭ��Ϊ6
	private Diamond[][] map; // ������ŷ���ĵ�ͼ
	private HashMap<Integer, Integer> removeList = new HashMap<Integer, Integer>(); // ������ż����������ķ���

	public GameLogic(int numberX, int numberY, int kindOfObj,
			int[][] input_map, GameView gameView) {
		this.numberX = numberX;
		this.numberY = numberY;
		this.kindOfObj = kindOfObj;
		this.gameView = gameView;
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

	public int move(int x, int y, int moveX, int moveY) {
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

		// �������
		if (!checkRemove()) {
			// �������ʧ�ܣ���ԭ״̬
			temp = map[oldX][oldY];
			map[oldX][oldY] = map[x][y];
			map[x][y] = temp;
			return MOVE_FAIL; // �����ƶ�ʧ��
		}

		// �������״̬��������Ƿ�������
		while (checkRemove()) {
			gameView.invalidate();
		}

		return MOVE_SUCCESS; // �����ƶ��ɹ�
	}

	private boolean canRemove() {
		removeList.clear();
		for (int i = 0; i < numberX; i++) {
			for (int j = 0; j < numberY; j++) {
				// ÿһ����������Χ���
				checkRemoveAt(i, j);
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

	private void checkRemoveAt(int x, int y) {
		if (x - 1 >= 0 && x + 1 < numberX) {
			if (map[x - 1][y].getId() == map[x][y].getId()
					&& map[x + 1][y].getId() == map[x][y].getId()) {
				int loc = x - 1 + y * numberX;
				removeList.put(loc, 1);
				removeList.put(loc + 1, 1);
				removeList.put(loc + 2, 1);
			}
		}
		if (y - 1 >= 0 && y + 1 < numberY) {
			if (map[x][y - 1].getId() == map[x][y].getId()
					&& map[x][y].getId() == map[x][y + 1].getId()) {
				removeList.put(x + y * numberX, 1);
				removeList.put(x + (y - 1) * numberY, 1);
				removeList.put(x + (y + 1) * numberX, 1);
			}
		}
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
