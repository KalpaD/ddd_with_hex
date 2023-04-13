package org.kds.ddd.hex.ddd_with_hex.domain.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;
import org.kds.ddd.hex.ddd_with_hex.arch.ddd.DddEntity;

import java.util.List;

@DddEntity
@Value
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Notification {
    String id;
    String message;
    List<Channels> channels;
}
