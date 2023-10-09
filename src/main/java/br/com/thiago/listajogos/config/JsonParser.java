package br.com.thiago.listajogos.config;

public interface JsonParser {
    <T> T toObject(String var1, Class<T> var2);

    String toJson(Object var1);
}