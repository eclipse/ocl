/*******************************************************************************
 * Copyright (c) 2013, 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *	 E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.build.modelspecs;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.autogen.autocgmodel.CGASTCallExp;
import org.eclipse.ocl.examples.autogen.autocgmodel.CGContainmentBody;
import org.eclipse.ocl.examples.autogen.autocgmodel.CGContainmentPart;
import org.eclipse.ocl.examples.autogen.autocgmodel.CGContainmentVisit;

public class AutoCGValuedElementModelSpec extends CGValuedElementModelSpec
{
	public static class Register {
	  public Register() {
//		new AutoCGValuedElementModelSpec(CGCallExp.class, null,							null     , null     , null     , null     , null     , Glo.FALSE, null     , null     , null    , null     , Val.THIS , null     , null     , null     , null     , null     );
		new AutoCGValuedElementModelSpec(CGASTCallExp.class, "source",	                Box.FALSE, null     , null     , null     , null     , null     , null     , null     , null    , null     , null     , null     , null     , null     , null     , null     , null    );
		new AutoCGValuedElementModelSpec(CGContainmentBody.class, null,					Box.FALSE, null     , null     , Nul.NEVER, null     , Glo.FALSE, null     , null     , null    , null     , null     , null     , null     , null     , Com.FALSE, null     , Eq.UNSUP);
		new AutoCGValuedElementModelSpec(CGContainmentPart.class, null,					Box.FALSE, null     , null     , Nul.NEVER, null     , Glo.FALSE, null     , null     , null    , null     , null     , null     , null     , null     , Com.FALSE, null     , Eq.UNSUP);
		new AutoCGValuedElementModelSpec(CGContainmentVisit.class, null,				Box.FALSE, null     , null     , Nul.NEVER, null     , Glo.FALSE, null     , null     , null    , null     , null     , null     , null     , null     , Com.FALSE, null     , Eq.UNSUP);
	  }
	}
	
	protected AutoCGValuedElementModelSpec(@NonNull Class<?> cgClass, @Nullable String delegate,
			@Nullable Box box, @Nullable Ths ths, @Nullable Log log, @Nullable Nul nul, @Nullable Inv inv,
			@Nullable Glo glo, @Nullable Inl inl, @Nullable Set set, @Nullable Ct ct, @Nullable Con con,
			@Nullable Val val, @Nullable Cvl cvl, @Nullable Ctx ctx, @Nullable Ctl ctl, @Nullable Com com, @Nullable Rew rew, @Nullable Eq eq) {
		super(cgClass, delegate, box, ths, log, nul, inv, glo, inl, set, ct, con, val, cvl, ctx, ctl, com, rew, eq);
	}
}
