package CollectionFramework;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;
import java.util.Scanner;

public class QueueExample {
	static Queue q = new LinkedList();
	static final int MAX_SIZE = 5;

	public static void main(String[] args) {
		while (true) {
			System.out.print(">>");
			try {
				// 화면으로부터 라인단위로 입력받음
				Scanner scan = new Scanner(System.in);
				String input = scan.nextLine().trim(); // 문자열 앞,뒤 공백 제거

				if ("".equals(input)) continue;

				if (input.equalsIgnoreCase("q")) { // 대소문자 구분하지 않고 검사
					System.exit(0);
				} else if (input.equalsIgnoreCase("help")) {
					System.out.println("help - 도움말");
					System.out.println("q/Q - 프로그램 종료");
					System.out.println("history - 최근 입력 명령어 최대 " + MAX_SIZE + "건 노출");

				} else if (input.equalsIgnoreCase("history")) {
					int i = 0;
					// 입력받은 명령어 저장
					save(input);
					// 최근 입력 명령어 출력
					LinkedList tmp = (LinkedList) q;
					ListIterator itr = tmp.listIterator();
					while (itr.hasNext()) {
						System.out.println(++i + ". " + itr.next()); // 순서및 다음 명령어 출력
					}
				} else {
					save(input);
					System.out.println(input);
				} // if(input.equalsIgnoreCase("q"))

			} catch (Exception e) {
				System.out.println("입력 오류입니다. ");
			}
		}
	}

	public static void save(String input) {
		// queue에 저장
		if (!"".equals(input))
			q.offer(input);

		// queue의 최대 크기를 넘으면 가장 오래된 것 삭제
		if (q.size() > MAX_SIZE)
			q.remove();
	}
}// end
