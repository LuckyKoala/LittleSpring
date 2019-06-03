package tech.zuosi.lk.littlespring.ioc.autowiring.components;

import tech.zuosi.lk.littlespring.ioc.annotation.Autowired;
import tech.zuosi.lk.littlespring.ioc.annotation.Component;

/**
 * Created by luckykoala on 19-2-28.
 */
@Component
public class Whole {
    private Piece piece;

    @Autowired
    public Whole(Piece piece) {
        this.piece = piece;
    }
}
