import java.io.*;

public class SimpleGameMain {
	public static void main(String[] args) {
		Console con = System.console();

		String user;
		int win = 0;
		int lose = 0;
		int total = 0;

		// -----------------------------------------------------------[������ �ε�]
		user = con.readLine("�г����� �Է��� �ּ���:");
		File parent = new File("d:\\", "����������");
		parent.mkdir();
		File f = new File(parent, user + ".dat");
		if (f.exists()) { // ����ڴг���.dat�� ���̺� ������ �ִ�?
			// inputStream -> DataInputStream���� ��ü �� read
			try {
				FileInputStream fis = new FileInputStream(f);
				DataInputStream dis = new DataInputStream(fis);

				// win/lose�� ����
				win = dis.readInt();
				lose = dis.readInt();
				total = dis.readInt();

				dis.close();
			} catch (FileNotFoundException e) {
				System.out.println(e.getMessage());
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
			System.out.println(user + "���� ���� �����͸� �ҷ��鿴���ϴ�.");
		} else {
			win = 0;
			lose = 0;
			total = 0;

			System.out.println(user + "���� �����͸� �ʱ�ȭ�Ͽ����ϴ�.");
		}

		// -----------------------------------------------------------[���� ����]

		while (true) {
			System.out.println("\n*********************************");
			System.out.println(	user + " ���� ����: " + total + " �� " + win + " �� " 
							+ ((total - win) - lose) + " �� " + lose + " ��");
			total++;
			String in = con.readLine("\n������ ����! \n1.���� 2.���� 3.�� \n>>");
			if (Math.random() > 0.3) {
				switch (in) {
				case "1":
					System.out.println(user+": ����.. \n����: ����!");
					break;
				case "2":
					System.out.println(user+": ����.. \n����: ��!");
					break;
				case "3":
					System.out.println(user+": ��.. \n����: ����!");
					break;
				default:
					System.out.println("�� �� �Է��ϼ̽��ϴ�.");
					total--;
					continue;
				}
				System.out.println("T-T ����� �����ϴ�...\n");
				lose++;
			} else {
				if (Math.random() > 0.25) {
					System.out.println("�����ϴ�!");
				} else {
					System.out.println("�Ǹ��մϴ�! ���� �����ƽ��ϴ�!!");
					win++;
				}
			}
			// ���� �� �� �Ϸ�.

			String sel = con.readLine("\n������ �����÷��� N"); // �ֿܼ� �׳� ����ġ�� sel�� null ��.
			if (sel.equalsIgnoreCase("N")) {
				break;
			}
		} // ���� ���� ����

		// -------------------------------------------------------------[������ ����]
		// ����� �̸����� ���� ����
		// ���� output -> DataOutputStream
		// �о ������� ���
		try {
			FileOutputStream fos = new FileOutputStream(f);
			DataOutputStream dos = new DataOutputStream(fos);
			dos.writeInt(win);
			dos.writeInt(lose);
			dos.writeInt(total);
			dos.close();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		System.out.println(user + " ���� �����Ͱ� �� ��ϵǾ����ϴ�.");
		
	}
}
