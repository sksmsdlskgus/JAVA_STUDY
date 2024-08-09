package com.ohgiraffers.section02.annotation.subsection04.resource;


import com.ohgiraffers.section02.annotation.common.Pokemon;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("pokemonServiceResource")
public class PokemonService {

    /* 설명. Pokemon으로 처리 시 */
//    @Resource(name = "charmander")
//    private Pokemon pokemon;

    /* 설명. List<Pokemon>으로 처리 시 */
    @Resource  // DI로 해석하자
    private List<Pokemon> pokemonList;

    public void pokemonAttack() {
//        pokemon.attack();
        pokemonList.forEach(Pokemon::attack);
    }
}
