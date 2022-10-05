package br.com.thiago.listajogos.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.stream.Stream;

@AllArgsConstructor
@Getter
public enum PlataformaEnum {

    EPICGAMES("epic-games"),
    GAMEBOY("gameboy"),
    GAMEBOYADVANCE("gameboy-advance"),
    GAMECUBE("gamecube"),
    GOG("gog"),
    N3DS("3ds"),
    N64("n64"),
    NDS("nds"),
    NES("nes"),
    MASTESYSTEM("master-system"),
    MEGADRIVE("mega-drive"),
    ORIGIN("origin"),
    PSONE("psone"),
    PS2("ps2"),
    PS3("ps3"),
    PS4("ps4"),
    PS5("ps5"),
    PSP("psp"),
    PSVITA("psvita"),
    SNES("snes"),
    STEAM("steam"),
    SWITCH("switch"),
    UBISOFTCONECT("ubisoft-connect"),
    WII("wii"),
    WIIU("wiiu"),
    XBOX("xbox"),
    XBOX360("xbox-360"),
    XBOXONE("xbox-one"),
    XBOXSERIES("xbox-series");

    private final String value;

    public static PlataformaEnum findByValue(final String value) {
        return Stream.of(values())
                .filter(v -> v.getValue().equalsIgnoreCase(value))
                .findFirst()
                .orElse(null);
    }
}
