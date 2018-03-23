package HttpSOAP.SOAPRequest;

import java.io.IOException;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class RequestSoap 
{

	//public String urlRequest = "http://localhost:9013/ngw/webservice.ws";
	//public String filePath = "C:\\Users\\angelica\\Documents\\KNOW\\test.xml";
	
	private String urlRequest;
	private String filePath;
	
	
	public String getUrlRequest() {
		return urlRequest;
	}




	public void setUrlRequest(String urlRequest) {
		this.urlRequest = urlRequest;
	}




	public String getFilePath() {
		return filePath;
	}




	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}




	public String sendRequest(){
		
		OkHttpClient client = new OkHttpClient();

		MediaType mediaType = MediaType.parse("text/xml");
		
	    try{
		      
		      
		        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		        DocumentBuilder builder = factory.newDocumentBuilder();
		        Document doc = builder.parse(getFilePath());
		        StringWriter stringWriter = new StringWriter(); 
		        Transformer transformer = TransformerFactory.newInstance().newTransformer(); 
		        transformer.transform(new DOMSource(doc), new StreamResult(stringWriter)); 
		        String strFileContent = stringWriter.toString(); //This is string data of xml file
		       
		        //System.out.println(strFileContent);


	    
		
		RequestBody body = RequestBody.create(mediaType,strFileContent);
		Request request = new Request.Builder()
				  .url(getUrlRequest())
				  .post(body)
				  .addHeader("content-type", "text/xml")
				  .method("POST", body)
				  .build();

		try {
			Response response = client.newCall(request).execute();
			//System.out.println(response.body().string());
			return response.body().string();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	    }
	    catch (Exception e){
	      e.getMessage();
	    }
		return "Request Fallido";


		
	}
}
