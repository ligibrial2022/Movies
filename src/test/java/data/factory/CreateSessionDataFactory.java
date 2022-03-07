package data.factory;

import com.github.javafaker.Faker;

import static model.CreateBodyBuilder.aBody;

import model.CreateSessionLogin;
import org.apache.commons.lang3.StringUtils;

public class CreateSessionDataFactory {

        private static final Faker faker= new Faker();
        public static CreateSessionLogin missingAllInformation(){
            return aBody().requestToken(StringUtils.EMPTY).username(StringUtils.EMPTY)
                    .password(StringUtils.EMPTY).build();
        }

    }

