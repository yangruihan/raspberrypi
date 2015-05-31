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

	// 定义一个私有的文件的绝对路径文本域对象
	private JTextField selectField;
	
	// 定义一个私有的编辑区对象
	private JTextArea editArea;
	
	// 定义一个私有的“保存”按钮对象
	private JButton saveBtn;
	
	// 定义一个私有的“浏览”按钮对象
	private JButton openFileBtn;
	
	// 定义一个私有的记录目录层次数，其初始值为0
	private int level = 0;
	
	public FileEditor() {
		this.init();
	}
	
	private void init() {
		// 设置标题
		this.setTitle("Editor");
		
		// 设置组件大小
		this.setBounds(300, 50, 600,650);

		/*
		 * 创建面板上北边的区域，即路径输入域、浏览按钮
		 */
		
		// 创建一个选择框对象
		selectField = new JTextField(40);
		
		// 创建一个按钮对象
		openFileBtn = new JButton("Browse");
		
		// 添加监听事件
		openFileBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				FileEditor.this.level = 0;
				String path = selectField.getText();
				
				// 浏览目录或者文件
				openDirOrFile(path.replaceAll("/", "\\"));
			}
		});
		
		// 新建一个流布局，并且左对齐的面板
		JPanel upPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		// 设置画板的背景颜色
		upPanel.setBackground(Color.CYAN);
		
		// 将选择框加入画板中
		upPanel.add(selectField);
		
		// 将按钮加入面板中
		upPanel.add(openFileBtn);
		
		// 将面板放在北边区域
		this.add(upPanel, BorderLayout.NORTH);
		
		/*
		 * 创建文本编辑区，并加入到整个布局的中间区域
		 */
		editArea = new JTextArea();
		ScrollPane scrollPane = new ScrollPane(ScrollPane.SCROLLBARS_AS_NEEDED);
		scrollPane.add(editArea);
		this.add(scrollPane, BorderLayout.CENTER);
		
		/*
		 * 创建保存按钮，并为按钮添加监听事件
		 */
		saveBtn = new JButton("Save");
		saveBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 保存
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
	 * 保存文件
	 */
	private void saveFile() {
		FileDialog fd = new FileDialog(this, "Save File");
		
		// 设置需要保存文件的后缀
		fd.setFile("*.java");
		
		// 设置为“保存”模式
		fd.setMode(FileDialog.SAVE);
		fd.setVisible(true);
		
		// 获取文件名
		String fileName = fd.getFile();
		
		// 获取对话框的当前目录
		String dir = fd.getDirectory();
		
		// 根据目录名、文件名创建一个文件，即要保存的目标文件
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
	 * 打开目录或文件
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
	 * 浏览目录，建立树形图
	 */
	private void showDir(File directory) {
		File[] files = directory.listFiles();
		
		int len = files.length;
		
		for (int i = 0; i < len; i++) {
			if (files[i].isDirectory()) {
				for (int j = 0; j < this.level; j++) {
					editArea.append("    ");
				}
				editArea.append(this.level+1+"  +"+files[i].getName()+ " 文件夹\r\n");
				this.level++;
				showDir(files[i]);
			} else if (files[i].isFile()) {
				for (int j = 0; j< this.level + 2; j++) {
					editArea.append("    ");
				}
				editArea.append(this.level+"  ┠──" + files[i].getAbsolutePath() +"\r\n");
			}
		}
	}
	
	public static void main(String[] args) {
		new FileEditor();
	}
}
