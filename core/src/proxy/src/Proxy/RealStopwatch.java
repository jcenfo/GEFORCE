package proxy.src.Proxy;

public class RealStopwatch implements IStopwatch{

    @Override
    public void tiempo(String tiempo) throws Exception {
        System.out.println("Comenzando: "+ tiempo);

    }
}
