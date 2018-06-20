package com.example.userposts.networking.services;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;
import retrofit2.Retrofit;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class UsersServiceAPIImp_MembersInjector
    implements MembersInjector<UsersServiceAPIImp> {
  private final Provider<Retrofit> retrofitProvider;

  public UsersServiceAPIImp_MembersInjector(Provider<Retrofit> retrofitProvider) {
    assert retrofitProvider != null;
    this.retrofitProvider = retrofitProvider;
  }

  public static MembersInjector<UsersServiceAPIImp> create(Provider<Retrofit> retrofitProvider) {
    return new UsersServiceAPIImp_MembersInjector(retrofitProvider);
  }

  @Override
  public void injectMembers(UsersServiceAPIImp instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.retrofit = retrofitProvider.get();
  }

  public static void injectRetrofit(
      UsersServiceAPIImp instance, Provider<Retrofit> retrofitProvider) {
    instance.retrofit = retrofitProvider.get();
  }
}
