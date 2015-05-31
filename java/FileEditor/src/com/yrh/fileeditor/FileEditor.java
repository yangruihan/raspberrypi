package com.yrh.fileeditor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class FileEditor extends JFrame{

	// ����һ��˽�е��ļ��ľ���·���ı������
	private JTextField selectField;
	
	// ����һ��˽�еı༭������
	private JTextArea editArea;
	
	// ����һ��˽�еġ����桱��ť����
	private JButton saveBtn;
	
	// ����һ��˽�еġ��������ť����
	private JButton openFileBtn;
	
	// ����һ��˽�еļ�¼Ŀ¼����������ʼֵΪ0
	private int level = 0;
	
	public FileEditor() {
		this.init();
	}
	
	private void init() {
		// ���ñ���
		this.setTitle("Editor");
		
		// ���������С
		this.setBounds(300, 50, 600,650);

		/*
		 * ��������ϱ��ߵ����򣬼�·�������������ť
		 */
		
		// ����һ��ѡ������
		selectField = new JTextField(40);
		
		// ����һ����ť����
		openFileBtn = new JButton("Browse");
		
		// ��Ӽ����¼�
		openFileBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				FileEditor.this.level = 0;
				String path = selectField.getText();
				
				// ���Ŀ¼�����ļ�
				openDirOrFile(path.replaceAll("/", "\\"));
			}
		});
		
		// �½�һ�������֣��������������
		JPanel upPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		// ���û���ı�����ɫ
		upPanel.setBackground(Color.CYAN);
		
		// ��ѡ�����뻭����
		upPanel.add(selectField);
		
		// ����ť���������
		upPanel.add(openFileBtn);
		
		// �������ڱ�������
		this.add(upPanel, BorderLayout.NORTH);
		
		/*
		 * �����ı��༭���������뵽�������ֵ��м�����
		 */
		editArea = new JTextArea();
		ScrollPane scrollPane = new ScrollPane(ScrollPane.SCROLLBARS_AS_NEEDED);
		scrollPane.add(editArea);
		this.add(scrollPane, BorderLayout.CENTER);
		
		/*
		 * �������水ť����Ϊ��ť��Ӽ����¼�
		 */
		saveBtn = new JButton("Save");
		saveBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// ����
				saveFile();
			}
		});
		
		JPanel southPanel = new JPanel();
		southPanel.setBackground(Color.GREEN);
		southPanel.add(saveBtn);
		this.add(southPanel, BorderLayout.SOUTH);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	/**
	 * �����ļ�
	 */
	private void saveFile() {
		FileDialog fd = new FileDialog(this, "Save File");
		
		// ������Ҫ�����ļ��ĺ�׺
		fd.setFile("*.java");
		
		// ����Ϊ�����桱ģʽ
		fd.setMode(FileDialog.SAVE);
		fd.setVisible(true);
		
		// ��ȡ�ļ���
		String fileName = fd.getFile();
		
		// ��ȡ�Ի���ĵ�ǰĿ¼
		String dir = fd.getDirectory();
		
		// ����Ŀ¼�����ļ�������һ���ļ�����Ҫ�����Ŀ���ļ�
		File newFile = new File(dir + File.separator + fileName);
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(newFile)));
			String str = editArea.getText();
			pw.println(str);
			pw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			pw.close();
		}
	}
	
	/**
	 * ��Ŀ¼���ļ�
	 */
	private void openDirOrFile(String absolutePath) {
		File file = new File(absolutePath);
		
		if (!(file.exists())) {
			editArea.setText("The file does not exist!");
		} else if (file.isDirectory()) {
			editArea.setText(null);
			showDir(file);
		} else if (file.isFile()) {
			try {
				FileInputStream fis = new FileInputStream(file);
				BufferedReader br = new BufferedReader(new InputStreamReader(fis));
				String str = null;
				editArea.setText(null);
				while ((str = br.readLine()) != null) {
					editArea.append(str + "\r\n");
				}
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * ���Ŀ¼����������ͼ
	 */
	private void showDir(File directory) {
		File[] files = directory.listFiles();
		
		int len = files.length;
		
		for (int i = 0; i < len; i++) {
			if (files[i].isDirectory()) {
				for (int j = 0; j < this.level; j++) {
					editArea.append("    ");
				}
				editArea.append(this.level+1+"  +"+files[i].getName()+ " �ļ���\r\n");
				this.level++;
				showDir(files[i]);
			} else if (files[i].isFile()) {
				for (int j = 0; j< this.level + 2; j++) {
					editArea.append("    ");
				}
				editArea.append(this.level+"  �ĩ���" + files[i].getAbsolutePath() +"\r\n");
			}
		}
	}
	
	public static void main(String[] args) {
		new FileEditor();
	}
}
