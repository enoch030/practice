import java.io.*;

public class SimpleGameMain {
	public static void main(String[] args) {
		Console con = System.console();

		String user;
		int win;
		int lose;
		int total;

		// -----------------------------------------------------------[데이터 로딩]
		user = con.readLine("사용자 닉네임?");
		File parent = new File("d:\\", "가위바위보");
		parent.mkdir();
		File f = new File(parent, user + ".dat");
		if (f.exists()) { // 사용자닉네임.dat의 세이브 파일이 있니?
			// inputStream -> DataInputStream으로 교체 후 read
			try {
				FileInputStream fis = new FileInputStream(f);
				DataInputStream dis = new DataInputStream(fis);

				// win/lose를 설정
				win = dis.readInt();
				lose = dis.readInt();
				total = dis.readInt();

				dis.close();
			} catch (FileNotFoundException e) {
				System.out.println(e.getMessage());
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
			System.out.println(user + "님의 기존 데이터를 불러들였습니다.");
		} else {
			win = 0;
			lose = 0;
			total = 0;

			System.out.println(user + "님의 데이터를 초기화하였습니다.");
		}

		// -----------------------------------------------------------[게임 진행]

		while (true) {
			System.out.println();
			String in = con.readLine("적과의 조우! \n1.가위 2.바위 3.보 \n>>");
			if (Math.random() > 0.2) {
				System.out.println("T-T 당신은 졌습니다...");
				switch (in) {
				case "1":
					System.out.println("전투 상세 # 당신은 가위.. 상대방은 바위!");
					break;
				case "2":
					System.out.println("전투 상세 # 당신은 바위.. 상대방은 보!");
					break;
				case "3":
					System.out.println("전투 상세 # 당신은 보.. 상대방은 가위!");
					break;
				default:
				}
			} else {
				if (Math.random() > 0.25) {
					System.out.println("비겼습니다!");
				} else {
					System.out.println("훌륭합니다! 적을 물리쳤습니다!!");
				}
			}
			// 게임 한 번 완료.

			String sel = con.readLine("모험을 끝내시려면 N"); // 콘솔에 그냥 엔터치면 sel에 null 들어감.
			if (sel.equals("N")) {
				break;
			}
		} // 게임 진행 종료

		// -------------------------------------------------------------[데이터 저장]
		// 사용자 이름으로 파일 만들어서
		try {
			FileOutputStream fos = new FileOutputStream(f);
			DataOutputStream dos = new DataOutputStream(fos);

			dos.close();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		// 파일 output -> DataOutputStream
		// 읽어낼 순서대로 출력
		catch (IOException e) {
			System.out.println(e.getMessage());
		}

		System.out.println(user + " 님의 데이터가 잘 기록되었습니다.");

	}
}
