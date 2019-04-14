package it.aldi.app.util;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Data
@Component
@PropertySource("classpath:i18n/messages_en.properties")
public class ErrorMsgConstant {

    @Value("${data-validation-bimbeluser-email}")
    private String emailExists;

    @Value("${data-validation-bimbeluser-username}")
    private String usernameExists;
}
