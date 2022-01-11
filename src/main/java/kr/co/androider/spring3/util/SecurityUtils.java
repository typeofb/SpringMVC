// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)
// Source File Name:   SecurityUtils.java

package kr.co.androider.spring3.util;

import edu.emory.mathcs.backport.java.util.Arrays;
import org.springframework.security.Authentication;
import org.springframework.security.GrantedAuthority;
import org.springframework.security.context.SecurityContext;
import org.springframework.security.context.SecurityContextHolder;
import org.springframework.security.userdetails.UserDetails;

// Referenced classes of package kr.co.androider.spring3.util:
//            StringUtils

public abstract class SecurityUtils
{

    public SecurityUtils()
    {
    }

    public static UserDetails getSignedUser()
    {
        SecurityContext context = SecurityContextHolder.getContext();
        if(context == null)
            return null;
        Authentication auth = context.getAuthentication();
        if(auth == null)
            return null;
        Object principal = auth.getPrincipal();
        if(principal == null)
            return null;
        if(principal instanceof UserDetails)
            return (UserDetails)principal;
        else
            return null;
    }

    public static String[] getUserRoles()
    {
        return getUserRoles(getSignedUser());
    }

    public static String[] getUserRoles(UserDetails user)
    {
        if(user == null)
            return null;
        GrantedAuthority authSet[] = user.getAuthorities();
        if(authSet.length <= 0)
            return null;
        String userRoles[] = new String[authSet.length];
        for(int i = 0; i < authSet.length; i++)
            userRoles[i] = authSet[i].getAuthority();

        return userRoles;
    }

    public static boolean hasRole(String role)
    {
        if(!StringUtils.hasText(role))
            return false;
        String roles[] = getUserRoles();
        if(roles == null || roles.length <= 0)
            return false;
        else
            return 0 <= Arrays.binarySearch(roles, role);
    }
}
