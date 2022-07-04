package sustech.blog.utils;

import org.apache.shiro.SecurityUtils;
import sustech.blog.shiro.AccountProfile;

public class ShiroUtils {
    public static AccountProfile getProfile() {
        return (AccountProfile) SecurityUtils.getSubject().getPrincipal();
    }
}
