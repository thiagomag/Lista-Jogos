package br.com.thiago.listajogos.config.r2dbc;

import br.com.thiago.listajogos.enums.converter.PlataformaEnumReadingConverter;
import br.com.thiago.listajogos.enums.converter.PlataformaEnumWritingConverter;
import br.com.thiago.listajogos.enums.converter.TipoEnumReadingConverter;
import br.com.thiago.listajogos.enums.converter.TipoEnumWritingConverter;
import io.r2dbc.pool.ConnectionPool;
import io.r2dbc.pool.ConnectionPoolConfiguration;
import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.r2dbc.R2dbcProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;
import org.springframework.data.r2dbc.convert.R2dbcCustomConversions;
import org.springframework.data.r2dbc.mapping.R2dbcMappingContext;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.data.relational.core.mapping.NamingStrategy;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@EnableR2dbcRepositories
@Configuration
@RequiredArgsConstructor
public class CustomR2dbcConfiguration extends AbstractR2dbcConfiguration {

    private final R2dbcProperties r2dbcProperties;

    @Bean
    @Override
    public ConnectionFactory connectionFactory() {
        final var connectionFactory = ConnectionFactories.get(r2dbcProperties.getUrl());

        final var connectionPoolConfiguration = ConnectionPoolConfiguration.builder(connectionFactory)
                .initialSize(r2dbcProperties.getPool().getInitialSize())
                .maxSize(r2dbcProperties.getPool().getMaxSize())
                .acquireRetry(5)
                .maxAcquireTime(Duration.ofMinutes(1))
                .build();

        return new ConnectionPool(connectionPoolConfiguration);
    }

    @Primary
    @Bean
    @Override
    public R2dbcMappingContext r2dbcMappingContext(Optional<NamingStrategy> namingStrategy, R2dbcCustomConversions r2dbcCustomConversions) {
        final var r2dbcMappingContext = super.r2dbcMappingContext(namingStrategy, r2dbcCustomConversions);
        r2dbcMappingContext.setForceQuote(Boolean.TRUE);
        return r2dbcMappingContext;
    }

    @Override
    protected List<Object> getCustomConverters() {
        return Arrays.asList(
                new PlataformaEnumReadingConverter(),
                new PlataformaEnumWritingConverter(),
                new TipoEnumReadingConverter(),
                new TipoEnumWritingConverter()
        );
    }

}
