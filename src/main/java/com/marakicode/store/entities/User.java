package com.marakicode.store.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(nullable = false, name = "name")
    private String name;

    @Column(nullable = false, name = "email", unique = true)
    private String email;

    @Column(nullable = false, name = "password")
    private String password;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST,
            CascadeType.REMOVE }, orphanRemoval = true)
    @Builder.Default
    List<Address> addresses = new ArrayList<>();

    public void addAddress(Address address) {
        addresses.add(address);
        address.setUser(this);
    }

    public void removeAddress(Address address) {
        addresses.remove(address);
        address.setUser(null);
    }

    @Builder.Default
    @ManyToMany
    @JoinTable(name = "user_tags", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private Set<Tag> tags = new HashSet<>();

    public void addTag(Tag tag) {
        tags.add(tag);
        tag.getUsers().add(this);
    }

    public void removeTag(Tag tag) {
        tags.remove(tag);
    }

    @OneToOne(mappedBy = "user", cascade = CascadeType.REMOVE)
    private Profile profile;

    public void addProfile(Profile profile) {
        this.profile = profile;
        profile.setUser(this);
    }

    @Builder.Default
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(name = "wishlist", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
    private Set<Product> wishlist = new HashSet<>();

    public void addWishlist(Product product) {
        wishlist.add(product);
    }
}
