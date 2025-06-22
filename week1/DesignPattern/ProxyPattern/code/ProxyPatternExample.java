public class ProxyPatternExample {
    public static void main(String[] args) {
        Image img1 = new ProxyImage("nature.jpg");
        Image img2 = new ProxyImage("wildlife.jpg");

        
        img1.display(); 
        img1.display(); 

        img2.display(); 
        img2.display(); 
    }
}
