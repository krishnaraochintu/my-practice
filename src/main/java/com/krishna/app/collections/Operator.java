package com.krishna.app.collections;

public enum Operator {
    ADD {
        @Override
        public int apply(int a, int b) {
            return 0;
        }
    }, MULTIPLY {
        @Override
        public int apply(int a, int b) {
            return 0;
        }
    }, SUBTRACT {
        @Override
        public int apply(int a, int b) {
            return 0;
        }
    }, DIVIDE {
        @Override
        public int apply(int a, int b) {
            return 0;
        }
    };
    public abstract int apply(int a, int b);
}
