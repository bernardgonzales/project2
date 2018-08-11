package edu.sdsu.cs;

import javax.crypto.spec.IvParameterSpec;

public interface IVertex<V> {
    String toString();

    V getName();

    int hashCode();

    boolean equals(IVertex<V> vertex);

    int getDistance();

    void setDistance(int distance);

    IVertex<V> getLast();

    void setLast(IVertex<V> last);

    void setPrevious(IVertex<V> prev);

    IVertex<V> getPrevious();
}