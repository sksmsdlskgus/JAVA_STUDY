package com.ohgiraffers.section01.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
public class LoggingAspect {

    /* 설명.
    *   타겟 클래스의 메소드에서 어드바이스를 적용할 수 있는 지점들을 조인 포인트(join point)라고 한다.
    *   포인트컷(pointcut)은 여러 조인포인트들에 어드바이스(advice)를 적용할 곳을 지정한 것이다.
    *    해당 조인포인트에서 어드바이스가 동작한다.
    *
    *   설명.
    *    <포인트컷 표현식>
    *      excution([수식어] 리턴 타입 [클래스이름] , 이름(파라미터))
    *      1. 수식어: public, private등 수식어를 명시(생략가능)
    *      2. 리턴 타입: 리턴 타입을 명시
    *      3. 클래스 이름(패키지 명 포함) 및 메소드 이름: 클래스 이름과 메소드 이름을 명시
    *      4. 파라미터(매개변수): 메소드의 파라미터를 명시
    *      5. "*": 1개이면서 모든 값이 올 수 있음
    *      6. ".." : 0개 이상의 모든값이 올 수 있음
    *
    *
    *   설명.
    *    execution(public Integer com.ohgiraffers.section01.advice.*.*(*))
    *    => com.ohgiraffers.section01.advice 패키지에 속해 있는 바로 다음 하위 클래스에 파라미터가 1개인 모든
    *       메소드이자 접근 제어자가 public이고, 반환형이 Integer인 경우
    *    execution( * com.ohgiraffers.section01.advice.annotation..stu*(..))
    *      => com.ohgiraffers.section01.advice 패키지에 속해 있고 이름이 stu로 시작하는 파라미터가
    *        0개 이상인 모든 메소드이며 접근제어자와 반환형은 상관없음
    * */

    @Pointcut("execution(* com.ohgiraffers.section01.aop.*Service.*(..))")
    public void logPointcut() {}
    // 저 범위가 너무 길어서 이렇게 메소드로 따로 뺄 수 있다



    /* 설명. 1. Before Advice */
//    @Before("execution(* com.ohgiraffers.section01.aop.*Service.*(..))")
    @Before("LoggingAspect.logPointcut()")
    public void logBefore(JoinPoint joinPoint) {
        // 어떤 대상에 어느시점에 동작할지 어노테이션으로 지정
        // 포인트 컷에 적용될식을 적은거임 --> 해석만 할 수 있으면 됨
        // (..) 는 매개변수가 어떻게 생겼는지임
        // 이 메소드 안에는 동작시킬 기능을 작성함 조인포인트 중 포인트컷으로 선정된게 넘어오는 느낌임
        System.out.println("Before joinPoint.getTarget(): " + joinPoint.getTarget());
        System.out.println("Before joinPoint.getSignature(): " + joinPoint.getSignature());
        if(joinPoint.getArgs().length > 0) {        // 매개변수가 하나라도 있다면
            System.out.println("Before joinPoint.getArgs()[0]: " + joinPoint.getArgs()[0]);
            // 있었다면 배열 형태로 몇번째에 나타난다.
        }
    }

    /* 설명. 2. After Advice */
    @After("LoggingAspect.logPointcut()")
    public void logAfter(JoinPoint joinPoint) {
        System.out.println("After joinPoint.getTarget(): " + joinPoint.getTarget());
        System.out.println("After joinPoint.getSignature(): " + joinPoint.getSignature());
        if(joinPoint.getArgs().length > 0) {        // 매개변수가 하나라도 있다면
            System.out.println("After joinPoint.getArgs()[0]: " + joinPoint.getArgs()[0]);
        }
    }

    /* 설명. 3. AfterReturning Advice */
    @AfterReturning(pointcut="logPointcut()", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        System.out.println("After Returning result: " + result);

        if (result != null && result instanceof List) {
            ((List<MemberDTO>) result).add(new MemberDTO(3L,"반환 값 가공"));
        }
    }

    /* 설명. 3. AfterThrowing Advice */
    @AfterThrowing(pointcut="logPointcut()", throwing = "exception")
    public void logAfterThrowing( Throwable exception ) {
        System.out.println("After Throwing exception: " + exception);

    }



}
