//package org.spring.practice01.shopping.config;
//
//import org.spring.practice01.shopping.service.UserAuthService;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
////CSRF cross site request forgery
//@Configuration
//@EnableWebSecurity //웹보안 활성화를위한 annotation
//public class SecurityConfig { //인증&인가 API생성 -> 보안성UP
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity httpsSecurity,UserAuthService userAuthService) throws Exception{
//        httpsSecurity.csrf(AbstractHttpConfigurer::disable) //csrf 방지
//                .authorizeRequests((authorize)->authorize //URL 별 권한 설정
//                .requestMatchers("/user/*","/*").permitAll() //localhost:8080/user/ 이나 localhost:8080은 permitted.
//                .requestMatchers("/board/**","/reply/**").authenticated() //anyRequest().authenticated())//다른 요청은 authenicated.
//                ).formLogin((formLogin)->formLogin
//                        //로그인페이지 설정
//                        .loginPage("/")
//                        .usernameParameter("username")
//                        .passwordParameter("password")
//                        .defaultSuccessUrl("/product/showAll")
//                        .loginProcessingUrl("/user/auth"))
//                .userDetailsService(userAuthService);
//
////                .formLogin((formLogIn)->formLogIn.loginPage("/"));
//                //.loginPage("/login.jsp")//사용자 정의 로그인 페이지
//        return httpsSecurity.build();
//    }
//
//    @Bean
//    public BCryptPasswordEncoder bCryptPasswordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
////    public static void main(String[] args){
////        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//////        $2a$10$DQExxCB1En9a0Kxp3AhmXO4F1tNNKLHlJbz5CGk82CSG18xIW8h7m
////        System.out.println(encoder.encode("a"));
////        System.out.println(encoder.matches("a","$2a$10$DQExxCB1En9a0Kxp3AhmXO4F1tNNKLHlJbz5CGk82CSG18xIW8h7m"));
////    }
//}
