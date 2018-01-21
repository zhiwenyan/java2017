package com.fumi.classloader;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TestTiger {
	public static void main(String[] args) {
		new tiger();
	}

}

class tiger extends JFrame implements Runnable {
	JLabel lb1;
	JLabel lb2;
	JLabel lb3;
	JLabel lb4;
	Thread t;
	int n1, n2, n3;
	boolean isStop; // �Ƿ�ʼ��ֹͣ

	public tiger() {
		setTitle("�ϻ���");
		setBounds(100, 100, 300, 300);
		setLayout(new BorderLayout());

		JLabel lb = new JLabel("����1601����Ϸ��", JLabel.CENTER);
		lb.setFont(new Font("����", Font.BOLD, 20));
		lb.setForeground(Color.blue);
		add(lb, BorderLayout.NORTH);

		JPanel p1 = new JPanel();
		add(p1, BorderLayout.CENTER);

		lb1 = new JLabel();
		p1.add(lb1);
		lb2 = new JLabel();
		p1.add(lb2);
		lb3 = new JLabel();
		p1.add(lb3);

		JButton bt1 = new JButton("��ʼ");
		bt1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// !isStop ��ֹ�ظ������ʼ
				if (!isStop) {
					isStop = true;
					// ����һ���߳� ִ������
					t = new Thread(tiger.this);
					t.start();
				}
			}
		});
		p1.add(bt1);
		JButton bt2 = new JButton("ֹͣ");
		bt2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// isStop==true ��ֹ�ظ����ֹͣ
				if (isStop) {
					isStop = false;
					t.stop();
					t = null; // ��ǰ�߳���Ϊ��
				}
				if (n1 == n2 && n2 == n3 && n1 == n3) {
					lb4.setText("��ϲ�㣬һ�Ƚ���");
				} else if (n1 == n2 || n2 == n3 || n1 == n3) {
					lb4.setText("��ϲ�㣬���Ƚ���");
				} else {
					lb4.setText("������զ�أ�");
				}
				System.out.println(n1 + ",," + n2 + ",," + n3);

			}
		});
		p1.add(bt2);

		lb4 = new JLabel("", JLabel.CENTER);
		lb4.setForeground(Color.red);
		add(lb4, BorderLayout.SOUTH);

		setVisible(true);
	}

	public void run() {
		Random rand = new Random();
		try {
			for (int i = 0; i < 9999; i++) {
				if (isStop) {
					Thread.sleep(1000);
					n1 = rand.nextInt(3) + 1;
					n2 = rand.nextInt(3) + 1;
					n3 = rand.nextInt(3) + 1;
					lb1.setIcon(new ImageIcon(TestTiger.class.getResource("/image/" + n1 + ".png")));
					lb2.setIcon(new ImageIcon(TestTiger.class.getResource("/image/" + n2 + ".png")));
					lb3.setIcon(new ImageIcon(TestTiger.class.getResource("/image/" + n3 + ".png")));
					System.out.println(n1 + "," + n2 + "," + n3);

				} else {
					// isStop=false,ֹͣ���ͽ�������ѭ��
					break;
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();

		}
	}
}
