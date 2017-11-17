<%@ page  contentType="application/pdf"%>
<%@ page  trimDirectiveWhitespaces="true"%>
<%@ page  import="net.sf.jasperreports.engine.JRDataSource"%>
<%@ page  import="net.sf.jasperreports.engine.JasperReport"%>
<%@ page  import="net.sf.jasperreports.engine.JasperCompileManager"%>
<%@ page  import="net.sf.jasperreports.engine.JasperFillManager"%>
<%@ page  import="net.sf.jasperreports.engine.JasperExportManager"%>
<%@ page  import="net.sf.jasperreports.engine.JasperPrint"%>
<%@ page  import="net.sf.jasperreports.engine.data.*"%>
<%@ page  import="java.io.*"%>
<%@ page  import="java.util.*"%>
 

<% 
try{
	List<Map<String, ?>> dataSource = (List<Map<String, ?>>) request.getAttribute("List");
	
	JRDataSource jrDataSource = new JRBeanCollectionDataSource(dataSource);
	String jrxmlFile = session.getServletContext().getRealPath("/WEB-INF/pdf/ReportSync.jrxml");
	Map<String, Object> parameters = new HashMap<String, Object>();
	
	InputStream input = new FileInputStream(new File(jrxmlFile));
	JasperReport jasperReport = JasperCompileManager.compileReport(input);
	HashMap parameterMap = new HashMap();
	parameterMap.put("TypeReport", request.getAttribute("TypeReport"));
	parameterMap.put("nameThai", request.getAttribute("nameThai"));
	parameterMap.put("address", request.getAttribute("address"));
	parameterMap.put("Date", request.getAttribute("Date"));
	parameterMap.put("User", request.getAttribute("User"));
	parameterMap.put("logo",session.getServletContext().getRealPath("/img/img_brand/logo.jpg"));
	JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,parameterMap,jrDataSource);
	JasperExportManager.exportReportToPdfStream(jasperPrint,response.getOutputStream());
	response.getOutputStream().flush();
	response.getOutputStream().close();
	}catch(IOException e){
	e.printStackTrace();
}
%>
