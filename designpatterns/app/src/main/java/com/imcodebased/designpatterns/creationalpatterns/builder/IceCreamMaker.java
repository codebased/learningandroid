package com.imcodebased.designpatterns.creationalpatterns.builder;

/**
 * Created by codebased on 22/1/17.
 */

public class IceCreamMaker {

    public IceCreamMaker(Builder builder) {
        this.flavour = builder.flavour;
        this.creamQuantity = builder.creamQuantity;
        this.milkQuantity = builder.milkQuantity;
        this.saltLevel = builder.saltLevel;
    }

    public static class Builder {
        private String flavour;
        private int milkQuantity;
        private int creamQuantity;
        private int saltLevel;

        public Builder() {

        }

        public IceCreamMaker build() {
            return new IceCreamMaker(this);
        }

        public Builder flavour(String flavour) {
            this.flavour = flavour;
            return this;
        }

        public Builder milkQuantity(int milkQuantity) {
            this.milkQuantity = milkQuantity;
            return this;
        }

        public Builder creamQuantity(int creamQuantity) {
            this.creamQuantity = creamQuantity;
            return this;
        }

        public Builder saltLevel(int saltLevel) {
            this.saltLevel = saltLevel;
            return this;
        }


    }

    private String flavour;
    private int milkQuantity;
    private int creamQuantity;
    private int saltLevel;
}

