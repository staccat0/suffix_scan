import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        SuffixList list = new SuffixList();
//        System.out.println(list.suffix[1]);
        for (int i = 0; i < list.suffix.length; i++) {
            if (isDomainExists(args[0] + list.suffix[i])) {
                System.out.println(args[0] + list.suffix[i]);
            }

        }
    }

    public static boolean isDomainExists(String domain) {
        try {
            InetAddress.getByName(domain); // 触发DNS解析
            return true;
        } catch (UnknownHostException e) {
            return false;
        }
    }

    // 使用Optional优化空值处理
    public static Optional<Boolean> checkDomainWithOptional(String domain) {
        return Optional.ofNullable(domain)
                .map(d -> {
                    try {
                        InetAddress.getByName(d);
                        return true;
                    } catch (UnknownHostException ex) {
                        return false;
                    }
                });
    }
}




