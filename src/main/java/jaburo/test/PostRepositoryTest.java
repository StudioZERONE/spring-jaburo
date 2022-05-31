package jaburo.test;

import javax.persistence.EntityManager;

public class PostRepositoryTest {
    @DisplayName("hi 내용을 포함하며 댓글이 1개 이상인 Post를 조회한다.")
    @Test
    void jpa_findPostsByMyCriteria_Three() {
        EntityManager entityManager = testEntityManager.getEntityManager();

        List<Post> posts = entityManager.createQuery("select p from Post p where p.content like '%hi%' and p.comments.size > 0 order by p.id desc", Post.class)
                .getResultList();

        assertThat(posts).hasSize(3);
    }
}
