public class Main {

    public static void main(String[] args) throws Exception {

        DomParser dom = new DomParser();
        dom.parse();
        JaxbParser jaxbparser = new JaxbParser();
        jaxbparser.parse();
        JacksonParser jp = new JacksonParser();
        jp.parse();
    }
}
