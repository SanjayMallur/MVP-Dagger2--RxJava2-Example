package com.example.userposts.networking.services;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;
import retrofit2.Retrofit;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class PhotosServiceAPIImp_MembersInjector
    implements MembersInjector<PhotosServiceAPIImp> {
  private final Provider<Retrofit> retrofitProvider;

  public PhotosServiceAPIImp_MembersInjector(Provider<Retrofit> retrofitProvider) {
    assert retrofitProvider != null;
    this.retrofitProvider = retrofitProvider;
  }

  public static MembersInjector<PhotosServiceAPIImp> create(Provider<Retrofit> retrofitProvider) {
    return new PhotosServiceAPIImp_MembersInjector(retrofitProvider);
  }

  @Override
  public void injectMembers(PhotosServiceAPIImp instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.retrofit = retrofitProvider.get();
  }

  public static void injectRetrofit(
      PhotosServiceAPIImp instance, Provider<Retrofit> retrofitProvider) {
    instance.retrofit = retrofitProvider.get();
  }
}
