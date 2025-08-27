package com.github.alexsurkov.weqapiintegration.service;

import com.github.alexsurkov.weqapiintegration.dto.CatDto;
import com.github.alexsurkov.weqapiintegration.exceptionhandler.CatApiUnauthorizedException;
import com.github.alexsurkov.weqapiintegration.mapper.CatMapper;
import feign.FeignException;
import io.github.resilience4j.ratelimiter.RateLimiter;
import lombok.RequiredArgsConstructor;
import net.proselyte.catapiintegration.api.CatsApi;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Supplier;

@Service
@RequiredArgsConstructor
public class CatService {

    private final CatMapper catMapper;
    private final CatsApi catsApi;
    private final RateLimiter catRateLimiter;

    public List<CatDto> getAll() {
        Supplier<List<CatDto>> supplier = () -> {
            try {
                var response = catsApi.getCats();
                var cats = response.getBody();
                return catMapper.toCatDto(cats);
            } catch (FeignException.Unauthorized ex) {
                throw new CatApiUnauthorizedException("Missing or incorrect external key", ex);
            }
        };
        return RateLimiter.decorateSupplier(catRateLimiter, supplier).get();
    }

    public CatDto getCatById(Long id) {
        Supplier<CatDto> supplier = () -> {
            try {
                var response = catsApi.getCatById(id);
                return catMapper.toCatDto(response.getBody());
            } catch (FeignException.Unauthorized ex) {
                throw new CatApiUnauthorizedException("Missing or incorrect external key", ex);
            }
        };
        return RateLimiter.decorateSupplier(catRateLimiter, supplier).get();
    }
}
