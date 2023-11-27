package com.team2.flea_market.security;

import com.team2.flea_market.dto.user.Role;
import com.team2.flea_market.entity.Ad;
import com.team2.flea_market.entity.Comment;
import com.team2.flea_market.entity.User;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Objects;
public class SecurityPermission {

    /**
     * Редактировать/удалять объявления может только владелец или администратор
     * @param ad объявление к которому необходимо проверить доступ
     * @param user текущий пользователь
     */
    public static void verifyAdPermissions(Ad ad, User user) {
        UserDetails userDetails = SecurityUser.fromUser(user);
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
    public static void verifyCommentPermissions(Comment comment, User user) {
        UserDetails userDetails = SecurityUser.fromUser(user);
        if (userDetails.getAuthorities().contains(Role.USER) && !Objects.equals(user.getId(), comment.getUser().getId())) {
            throw new AccessDeniedException(
                    "Чтобы изменить/удалить комментарий, нужно иметь роль ADMIN или быть владельцем этого комментария"
            );
        }
    }

}
