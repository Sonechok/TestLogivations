package com.sonechok.algorithm;

import com.sonechok.entity.Case;
import com.sonechok.entity.Orderline;

public interface ProductPackagingAlgorithmInterface {
    Case findOptimalCase(Orderline orderline);
}
