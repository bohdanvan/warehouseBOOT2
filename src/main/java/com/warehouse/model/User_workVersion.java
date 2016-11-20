//package com.warehouse.model;
//
//import javax.persistence.*;
//import java.util.HashSet;
//import java.util.Set;
//
//@Entity
//public class User_workVersion {
//
//    private static final long serialVersionUID = 1L;
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private long id;
////    @Size(min=3, max=6)
//    private String login;
////    @Size(min=4)
//    private String password;
//
//    private String passport;
//    private String email;
//
//    private String status = Status.ACTIVE.getState();
//    private int enabled;
//    private String language;
//
//
////	@OneToMany(mappedBy = "userJOIN", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
////	private List<IncDel> incDelListJOIN = new ArrayList<IncDel>();
//
////
////	@OneToMany(targetEntity = Recipient.class,fetch = FetchType.EAGER)
////	List<Recipient> recipientsListJOIN;
//
//    //	@JoinTable(name = "APP_USER_USER_ROLE",
////			joinColumns = {@JoinColumn(name = "USER_ID")},
////			inverseJoinColumns = {@JoinColumn(name = "USER_ROLE_ID")})
//    @ManyToMany(fetch = FetchType.EAGER, targetEntity = UserRole.class)
//    private Set<UserRole> userRolesHashSetJOIN = new HashSet<UserRole>();
//
//    public void addRole(String roleType){
//
//    }
//
//
//    public User_workVersion() {
//    }
//
//    public User_workVersion(String login) {
//        this.login = login;
//    }
//
//
//
//
//    //
////    /**
////     * Construct the <code>User</code> with the details required by
////     * {@link org.springframework.security.authentication.dao.DaoAuthenticationProvider}.
////     *
////     * @param login the login presented to the
////     *        <code>DaoAuthenticationProvider</code>
////     * @param password the password that should be presented to the
////     *        <code>DaoAuthenticationProvider</code>
////     * @param enabled set to <code>true</code> if the user is enabled
////     * @param accountNonExpired set to <code>true</code> if the account has not
////     *        expired
////     * @param credentialsNonExpired set to <code>true</code> if the credentials
////     *        have not expired
////     * @param accountNonLocked set to <code>true</code> if the account is not
////     *        locked
////     * @param userRolesHashSetJOIN the authorities that should be granted to the caller
////     *        if they presented the correct login and password and the user
////     *        is enabled. Not null.
////     *
////     * @throws IllegalArgumentException if a <code>null</code> value was passed
////     *         either as a parameter or as an element in the
////     *         <code>GrantedAuthority</code> collection
////     */
////    public User(String login, String password, int enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Set<UserRole> userRolesHashSetJOIN) {
////        if (((login == null) || "".equals(login)) || (password == null)) {
////            throw new IllegalArgumentException("Cannot pass null or empty values to constructor");
////        }
////        this.login = login;
////        this.password = password;
////        this.enabled = enabled;
////        this.accountNonExpired = accountNonExpired;
////        this.credentialsNonExpired = credentialsNonExpired;
////        this.accountNonLocked = accountNonLocked;
////        this.userRolesHashSetJOIN = userRolesHashSetJOIN;
////    }
////
//
//
//
//
//
//
////    Getters Setters
//
//    public static long getSerialVersionUID() {
//        return serialVersionUID;
//    }
//
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public String getLogin() {
//        return login;
//    }
//
//    public void setLogin(String login) {
//        this.login = login;
//    }
//
//    public String getPassport() {
//        return passport;
//    }
//
//    public void setPassport(String passport) {
//        this.passport = passport;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
//
//    public int getEnabled() {
//        return enabled;
//    }
//
//    public void setEnabled(int enabled) {
//        this.enabled = enabled;
//    }
//
////    public boolean isAccountNonExpired() {
////        return accountNonExpired;
////    }
////
////    public void setAccountNonExpired(boolean accountNonExpired) {
////        this.accountNonExpired = accountNonExpired;
////    }
////
////    public boolean isCredentialsNonExpired() {
////        return credentialsNonExpired;
////    }
////
////    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
////        this.credentialsNonExpired = credentialsNonExpired;
////    }
////
////    public boolean isAccountNonLocked() {
////        return accountNonLocked;
////    }
////
////    public void setAccountNonLocked(boolean accountNonLocked) {
////        this.accountNonLocked = accountNonLocked;
////    }
//
//    public Set<UserRole> getUserRolesHashSetJOIN() {
//        return userRolesHashSetJOIN;
//    }
//
//    public void setUserRolesHashSetJOIN(Set<UserRole> userRolesHashSetJOIN) {
//        this.userRolesHashSetJOIN = userRolesHashSetJOIN;
//    }
//
//    public String getLanguage() {
//        return language;
//    }
//
//    public void setLanguage(String language) {
//        this.language = language;
//    }
//
//
//}