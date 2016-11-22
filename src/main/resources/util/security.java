//package com.warehouse.util;
//
//import javax.servlet.http.HttpServletRequest;
//
///**
// * Created by user on 14.11.2016.
// */
//public class security {
//    public static void main(String[] args) {
//
//    }
//
//   static void http(HttpServletRequest httpServletRequest) {
//       boolean isAdmin = httpServletRequest.isUserInRole("ADMIN");
//       System.out.println(isAdmin);
//   }
//
//
////FOR JSON and AJAX query
//
////    <meta name="_csrf" content="${_csrf.token}"/>
////    <!-- default header name is X-CSRF-TOKEN -->
////    <meta name="_csrf_header" content="${_csrf.headerName}"/>
////
////    JQuery varsion
////$(function () {
////    var token = $("meta[name='_csrf']").attr("content");
////    var header = $("meta[name='_csrf_header']").attr("content");
////    $(document).ajaxSend(function(e, xhr, options) {
////        xhr.setRequestHeader(header, token);
////    });
////});
//
//
//
//// ...
//
//
//
//
////    import org.springframework.security.core.annotation.AuthenticationPrincipal;
////    @RequestMapping("/messages/inbox")
////    public ModelAndView findMessagesForUser(@AuthenticationPrincipal CustomUser customUser) {
////        // .. find messages for this user and return them ...
////    }
//
//
//}
