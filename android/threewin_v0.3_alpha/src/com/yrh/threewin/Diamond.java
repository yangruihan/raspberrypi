package com.yrh.threewin;

import android.graphics.Color;

/**
 * ������ÿ�������еķ���
 * 
 * @author Yrh
 *
 */
public class Diamond {

	public static final int KIND_WALL = 1689; // ��ʾǽ��
	public static final int KIND_OBJ = KIND_WALL + 1; // ��ʾ����������
	
	private int kind; // ���࣬
	private int color; // ��ɫ���Ժ���ͼƬ����
	private int id; // ͨ�� id ������ͬ����
	private int x; // �������е� x ����
	private int y; // �������е� y ����
//	private int[] colorList = {0x000000, 0xbf0000, 0x7ecd18, 0xeb858c, 0x3b9dd5, 0x7f6247};
	public static final int[] COLOR_LIST = {Color.BLACK, Color.GREEN, Color.BLUE, Color.RED, Color.YELLOW, Color.MAGENTA};
	private boolean isPush; // �Ƿ񱻰���
			
	// ���캯��
	public Diamond(int kind, int id, int x, int y) {
		this.kind = kind;
		this.id = id;
		this.x = x;
		this.y = y;
		this.isPush = false;
		this.color = COLOR_LIST[this.id - 1];
	}
	
	/* Get ���� */
	public boolean isPush() {
		return isPush;
	}

	public void setPush(boolean isPush) {
		this.isPush = isPush;
	}

	public int getKind() {
		return kind;
	}
	
	public int getColor() {
		return this.color;
	}

	public int getId() {
		return id;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

}
