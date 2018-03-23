package HttpSOAP.SOAPRequest;

import java.util.Scanner;

public class App2 {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("ingrese url:");
		String a = sc.next();

		System.out.println("ingrese path:");
		String b = sc.next();
		
		System.out.println("ingrese las iteraciones a enviar :");
		int c = sc.nextInt();
		
		System.out.println("ingrese los hilos a usar max 5");
		int d = sc.nextInt();
		
		
		
		int threadCant = d;
		
		switch (threadCant) {
		case 1:
			(new Thread(new ThreadService(a, b,c))).start();
			break;
		case 2:
			(new Thread(new ThreadService(a, b,c))).start();
			(new Thread(new ThreadService(a, b,c))).start();
			break;
		case 3:
			(new Thread(new ThreadService(a, b,c))).start();
			(new Thread(new ThreadService(a, b,c))).start();
			(new Thread(new ThreadService(a, b,c))).start();
			break;	
		case 4:
			(new Thread(new ThreadService(a, b,c))).start();
			(new Thread(new ThreadService(a, b,c))).start();
			(new Thread(new ThreadService(a, b,c))).start();
			(new Thread(new ThreadService(a, b,c))).start();
			break;
		case 5:
			(new Thread(new ThreadService(a, b,c))).start();
			(new Thread(new ThreadService(a, b,c))).start();
			(new Thread(new ThreadService(a, b,c))).start();
			(new Thread(new ThreadService(a, b,c))).start();
			(new Thread(new ThreadService(a, b,c))).start();
			break;
		default:
			(new Thread(new ThreadService(a, b,c))).start();
			break;
		}
		
		/**
		RequestSoap prueba = new RequestSoap();
		//prueba.setUrlRequest("http://localhost:9013/ngw/webservice.ws");
		prueba.setUrlRequest(a);
		//prueba.setFilePath("C:\\Users\\angelica\\Documents\\KNOW\\test.xml");
		prueba.setFilePath(b);
		
		for(int i = 0 ; i < c ; i++){
			System.out.println(prueba.sendRequest()+"---"+i);	
		}
		
		**/
		
	}

}
