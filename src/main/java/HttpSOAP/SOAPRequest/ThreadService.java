package HttpSOAP.SOAPRequest;

public class ThreadService extends Thread
{
	RequestSoap prueba = new RequestSoap();
	
	private int iteraccion;
	
	public ThreadService(String a , String b, int c) {
		
		//prueba.setUrlRequest("http://localhost:9013/ngw/webservice.ws");
		prueba.setUrlRequest(a);
		//prueba.setFilePath("C:\\Users\\angelica\\Documents\\KNOW\\test.xml");
		prueba.setFilePath(b);
		this.iteraccion=c;
	}
	
	
	@Override
	public void run()
	{
		for(int i = 0 ; i < iteraccion ; i++){
			System.out.println(prueba.sendRequest()+"---"+i);	
		}

	}


	
}
