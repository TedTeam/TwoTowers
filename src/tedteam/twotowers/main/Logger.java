package tedteam.twotowers.main;

public class Logger {
	public static int count = 0;
	public String param = "";

	public static void enter(String obj, String method, String param1,
			String param2) {
		count++;
		String param = checkParam(param1, param2);

		for (int i = 1; i < count; i++) {
			System.out.print("   ");

		}

		System.out.println("-> " + obj + "." + method + "(" + param + ")");

	}

	public static void exit(String retType) {
		count--;

		for (int i = 0; i < count; i++) {
			System.out.print("   ");

		}

		System.out.println("<- " + retType);

	}

	public static String checkParam(String param1, String param2) {
		String param;
		if (param1.equals("") & param2.equals("")) {
			param = "";
		} else if (param2.equals("")) {
			param = param1;
		} else {
			param = param1 + "," + param2;
		}
		return param;
	}

}
