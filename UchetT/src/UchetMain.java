
import java.util.*;
public class UchetMain {

	public static void main(String[] args) {

		System.out.println("Hello World");
		String[] SkuAndType =new String[1000]; //� ������ ������ ����������� �� ���������� ������������ 1000
		for (String str1 : SkuAndType) {str1="empty";}//��������� ���� ������ ��������� �����
		while (true) {
			Scanner sc = new Scanner(System.in);
			String command;
			command = sc.nextLine();
			if (command.equals("exit")) break;
			// ���� ���������� �� ����� ����� ������ �� --
			String[] commandArray=command.split("--");
			//System.out.println(commandArray[1]); ��� ���� ����� ��� �����
			if (commandArray[0].equals("add ")) {
				switch (commandArray[2]) {
				case "type PRINTER ":
					printer p=new printer();
					p.addPrinter(commandArray);
					System.out.println(p.PrinterToStr());
					break;
				case "type SCANER ":
					scaner s=new scaner();
					s.addScaner(commandArray);
					System.out.println(s.ScanerToStr());
					break;
				case "type MONITOR ":
					monitor m=new monitor();
					m.addMonitor(commandArray);
					System.out.println(m.MoniToStr());
					break;
				default:
					System.out.println("I don't know this type");
					break;
				}
				}		


		}
	}
}

