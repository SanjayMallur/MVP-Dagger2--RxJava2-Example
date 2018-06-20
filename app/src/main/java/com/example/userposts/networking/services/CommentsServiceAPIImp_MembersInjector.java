package com.example.userposts.networking.services;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;
import retrofit2.Retrofit;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class CommentsServiceAPIImp_MembersInjector
    implements MembersInjector<CommentsServiceAPIImp> {
  private final Provider<Retrofit> retrofitProvider;

  public CommentsServiceAPIImp_MembersInjector(Provider<Retrofit> retrofitProvider) {
    assert retrofitProvider != null;
    this.retrofitProvider = retrofitProvider;
  }

  public static MembersInjector<CommentsServiceAPIImp> create(Provider<Retrofit> retrofitProvider) {
    return new CommentsServiceAPIImp_MembersInjector(retrofitProvider);
  }

  @Override
  public void injectMembers(CommentsServiceAPIImp instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.retrofit = retrofitProvider.get();
  }

  public static void injectRetrofit(
      CommentsServiceAPIImp instance, Provider<Retrofit> retrofitProvider) {
    instance.retrofit = retrofitProvider.get();
  }
}
