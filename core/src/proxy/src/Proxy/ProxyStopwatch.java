package proxy.src.Proxy;
import java.util.ArrayList;
import java.util.List;

public class ProxyStopwatch implements IStopwatch{

    private IStopwatch stopwatch = new RealStopwatch();
    private static List<String> differentTimes;

    static
    {
        differentTimes = new ArrayList<String>();
        differentTimes.add("abc.com");
        differentTimes.add("def.com");
        differentTimes.add("ijk.com");
        differentTimes.add("lnm.com");
    }

    @Override
    public void tiempo(String tiempo) throws Exception {
        if(differentTimes.contains("30"))
        {
//            throw new Exception("Access Denied");
            stopwatch.tiempo(tiempo);
        }

        throw new Exception("Access Denied");
    }
}