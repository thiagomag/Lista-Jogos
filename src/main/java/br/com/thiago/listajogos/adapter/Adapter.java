package br.com.thiago.listajogos.adapter;

public interface Adapter<Source, Destination> {

    Destination adapt(Source source);

    Destination adapt(Source source, Destination destination);

}
