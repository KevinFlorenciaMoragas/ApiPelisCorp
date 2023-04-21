package ApiProyectoM12.config;
/*
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.session.jdbc.config.annotation.web.http.EnableJdbcHttpSession;
import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer;
import org.springframework.transaction.PlatformTransactionManager;
import javax.sql.DataSource;

@Configuration
@EnableJdbcHttpSession
public class SessionConfig extends AbstractHttpSessionApplicationInitializer {
   @Autowired
    private DataSource dataSource;
   @Bean
   public EmbeddedDatabase dataSource() {
     return new EmbeddedDatabaseBuilder()
             .setType(EmbeddedDatabaseType.valueOf("MYSQL"))
             .addScript("classpath:org/springframework/session/jdbc/schema-mysql.sql").build();
   }
   @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource){
       return new DataSourceTransactionManager(dataSource);
   }
}*/
