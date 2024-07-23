package API;

public class Main {

  public static void main(String args[]){
    Service service = new Service();
    service.sendGetRequest();
    service.sendPostRequest();
  }
}
