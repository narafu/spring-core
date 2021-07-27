package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton() {

        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        // Thread A : A 사용자 - 10,000원 주문
//        statefulService1.order("userA", 10000);
        int userAPrice = statefulService1.order("userA", 10000);
        // Thread B : B 사용자 - 20,000원 주문
//        statefulService2.order("userB", 20000);
        int userBPrice = statefulService2.order("userB", 20000);

        // Thread A : 사용자 A 주믄 금액 조회
//        int price = statefulService1.getPrice();
        // 사용자 B의 금액이 조회된다.
        System.out.println("price = " + userAPrice);

//        Assertions.assertThat(userAPrice).isEqualTo(20000);
    }

    static class TestConfig {

        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }

}