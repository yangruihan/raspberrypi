package com.yrh.threewin;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class GameView extends View {

	public GameView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	public GameView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	public GameView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		// TODO Auto-generated constructor stub
	}

	/*---------------------------------------------------------------*/

	private int numberX = 7; // x ���Ϸ��������Ĭ��Ϊ8
	private int numberY = 7; // y ���Ϸ��������Ĭ��Ϊ8
	private int kindOfObj = 6; // ��������������Ĭ��Ϊ6
	private float diaWidth = 0f; // ÿһ������Ŀ��
	private float diaHeight = 0f; // ÿһ������ĸ߶�
	private float lineWidth = 8f; // �ָ��ߵĿ��
	private int moveX; // ˮƽ�ƶ��ķ���
	private int moveY; // ��ֱ�ƶ��ķ���
	private int[][] map = GameLogic.MAP_7x7;
	private GameLogic game = new GameLogic(numberX, numberY, kindOfObj, map,
			this); // ��Ϸ�߼���

	// ��д onDraw ����������Ϸ����
	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);

		Paint backgroundPaint = new Paint();
		backgroundPaint.setColor(getResources().getColor(R.color.lineColor));
		canvas.drawRect(0, 0, getWidth(), getHeight(), backgroundPaint);

		diaWidth = getWidth() / numberX; // �õ�ÿ�鷽��Ŀ��
		diaHeight = getHeight() / numberY; // �õ�ÿ�鷽��ĸ߶�

		// ���Ʒ���
		Paint diaPaint = new Paint();
		for (int i = 0; i < numberX; i++) {
			for (int j = 0; j < numberY; j++) {
				diaPaint.setColor(game.getDiaAt(i, j).getColor());
				// canvas.drawRect(i * diaWidth, j * diaHeight,
				// (i + 1) * diaWidth, (j + 1) * diaHeight, diaPaint);
				canvas.drawRoundRect(new RectF(i * diaWidth, j * diaHeight,
						(i + 1) * diaWidth, (j + 1) * diaHeight), 30f, 40f,
						diaPaint);
			}
		}

		// ���Ʒָ���
		Paint linePaint = new Paint();
		linePaint.setColor(getResources().getColor(R.color.lineColor));
		linePaint.setStrokeWidth(lineWidth);
		for (int i = 0; i < numberX; i++) {
			canvas.drawLine(i * diaWidth, 0, i * diaWidth, getHeight(),
					linePaint);
		}
		for (int i = 0; i < numberY; i++) {
			canvas.drawLine(0, i * diaHeight, getWidth(), i * diaHeight,
					linePaint);
		}

	}

	private float oldPointX = 0f; // ��¼���µ�� x ����
	private float oldPointY = 0f; // ��¼���µ�� y ����

	private int pushX; // ���µķ���� x ����
	private int pushY; // ���µķ���� y ����

	// ��д��������
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:

			oldPointX = event.getX(); // �õ����µ�� x ����
			oldPointY = event.getY(); // �õ����µ�� y ����

			pushX = (int) (oldPointX / diaWidth);
			pushY = (int) (oldPointY / diaHeight);

			Log.i("mytag", "(" + pushX + ", " + pushY + ")");
			Log.i("mytag", "��ǰ��״̬" + game.getDiaAt(pushX, pushY).getId() + " "
					+ game.getDiaAt(pushX, pushY).getColor());

			return true;

		case MotionEvent.ACTION_MOVE:
			// �ƶ�������������ʱ������
			float pointX = event.getX() - oldPointX;
			float pointY = event.getY() - oldPointY;

			// �����ָû���ƶ�һ������Ŀ�ȣ�������ƶ�
			if (Math.abs(pointX) < diaWidth && Math.abs(pointY) < diaHeight) {
				return false;
			}

			// �ж��ƶ��ķ���
			if (Math.abs(pointX) > Math.abs(pointY)) {
				if (pointX > 0) {
					moveX = +1;
				} else {
					moveX = -1;
				}
			} else {
				if (pointY > 0) {
					moveY = +1;
				} else {
					moveY = -1;
				}
			}
			return true;

		case MotionEvent.ACTION_UP:
			if (moveX == 0 && moveY == 0) {
				return false;
			}

			// ������Ϸ�߼��࣬�ƶ����飬���� True �ƶ��ɹ������� False �ƶ�ʧ��
			if (game.move(pushX, pushY, moveX, moveY) == GameLogic.MOVE_SUCCESS) {
				Log.i("mytag", "�ƶ��ɹ���");
			} else {
				Log.i("mytag", "�ƶ�ʧ�ܣ�");
			}

			// ˢ�»���
			invalidate();

			// ��ԭ״̬
			oldPointX = 0;
			oldPointY = 0;
			moveX = 0;
			moveY = 0;

			return true;
		}
		return super.onTouchEvent(event);
	}

	public void refresh() {
		this.invalidate();
	}

	// ������Ϸ�Ѷȵ�
	public void setGame(int numberX, int numberY, int kindOfObj, int[][] input_map) {
		this.numberX = numberX;
		this.numberY = numberY;
		this.kindOfObj = kindOfObj;
		this.map = input_map;
		this.game = new GameLogic(this.numberX, this.numberY, this.kindOfObj, this.map, this);
		// ˢ�»���
		invalidate();
	}

	/* Get Set ���� */
	public GameLogic getGame() {
		return game;
	}

	public int getKindOfObj() {
		return kindOfObj;
	}

	public void setKindOfObj(int kindOfObj) {
		this.kindOfObj = kindOfObj;
	}

	public int[][] getMap() {
		return map;
	}

	public void setMap(int[][] map) {
		this.map = map;
	}

	public int getNumberX() {
		return numberX;
	}

	public void setNumberX(int numberX) {
		this.numberX = numberX;
	}

	public int getNumberY() {
		return numberY;
	}

	public void setNumberY(int numberY) {
		this.numberY = numberY;
	}

	public float getLineWidth() {
		return lineWidth;
	}

	public void setLineWidth(float lineWidth) {
		this.lineWidth = lineWidth;
	}

}
