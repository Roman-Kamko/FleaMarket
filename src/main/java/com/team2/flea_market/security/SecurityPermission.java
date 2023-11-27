package com.team2.flea_market.security;

import com.team2.flea_market.dto.user.Role;
import com.team2.flea_market.entity.Ad;
import com.team2.flea_market.entity.Comment;
import com.team2.flea_market.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class SecurityPermission {

    private final UserDetailsService userDetailsService;

    /**
     * Редактировать/удалять объявления может только владелец или администратор
     * @param ad объявление к которому необходимо проверить доступ
     * @param user текущий пользователь
     */
    public void verifyAdPermissions(Ad ad, User user) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(user.getEmail());
        if (userDetails.getAuthorities().contains(Role.USER) && !Objects.equals(user.getId(), ad.getUser().getId())) {
            throw new AccessDeniedException(
                    "Чтобы изменить/удалить объявление, нужно иметь роль ADMIN или быть владельцем этого объявления"
            );
        }
    }

    /**
     * Редактировать/удалять комментарии может только владелец или администратор
     * @param comment комментарий к которому необходимо проверить доступ
     * @param user текущий пользователь
     */
    public void verifyCommentPermissions(Comment comment, User user) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(user.getEmail());
        if (userDetails.getAuthorities().contains(Role.USER) && !Objects.equals(user.getId(), comment.getUser().getId())) {
            throw new AccessDeniedException(
                    "Чтобы изменить/удалить комментарий, нужно иметь роль ADMIN или быть владельцем этого комментария"
            );
        }
    }

}
