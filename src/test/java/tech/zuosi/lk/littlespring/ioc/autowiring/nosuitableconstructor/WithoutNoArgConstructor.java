package tech.zuosi.lk.littlespring.ioc.autowiring.nosuitableconstructor;

import tech.zuosi.lk.littlespring.ioc.annotation.Component;

/**
 * Created by luckykoala on 19-3-1.
 */
@Component
public class WithoutNoArgConstructor {
    private Piece piece;

    public WithoutNoArgConstructor(Piece piece) {
        this.piece = piece;
    }
}
