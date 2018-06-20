package com.example.userposts.networking.services;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;
import retrofit2.Retrofit;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class PostServiceAPIImp_MembersInjector implements MembersInjector<PostServiceAPIImp> {
  private final Provider<Retrofit> retrofitProvider;

  public PostServiceAPIImp_MembersInjector(Provider<Retrofit> retrofitProvider) {
    assert retrofitProvider != null;
    this.retrofitProvider = retrofitProvider;
  }

  public static MembersInjector<PostServiceAPIImp> create(Provider<Retrofit> retrofitProvider) {
    return new PostServiceAPIImp_MembersInjector(retrofitProvider);
  }

  @Override
  public void injectMembers(PostServiceAPIImp instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.retrofit = retrofitProvider.get();
  }

  public static void injectRetrofit(
      PostServiceAPIImp instance, Provider<Retrofit> retrofitProvider) {
    instance.retrofit = retrofitProvider.get();
  }
}
